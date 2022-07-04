package com.spring.controller;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import com.spring.domain.Departs;
import com.spring.domain.Records;
import com.spring.domain.Staffs;
import com.spring.model.RecordModel;
import com.spring.model.StaffModel;
import com.spring.repository.StaffRepository;
import com.spring.service.DepartService;
import com.spring.service.RecordService;
import com.spring.service.StaffService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class Contronller {
	@Autowired
	ServletContext application;
	
	@Autowired
	StaffService staffService;
	
	@Autowired
	DepartService departService;
	
	@Autowired
	RecordService recordService;
	
	@Autowired
	StaffRepository staffRepository;
	@RequestMapping("home")
	public String login(ModelMap model) {
		List<Records> list=  recordService.findAll();
		model.addAttribute("records", list);
		
		return "home";
	}
	
	@RequestMapping("depart")
	public String showDepart(ModelMap model) {
		
		Long countAcc= staffRepository.countByDepartsId("acc");
		Long countBus= staffRepository.countByDepartsId("bus");
		Long countIt= staffRepository.countByDepartsId("it");
		Long countMan= staffRepository.countByDepartsId("man");
		Long countPer= staffRepository.countByDepartsId("per");
		Long countAll= staffRepository.count();
		Long countFemale = staffRepository.countByGender(false);
		model.addAttribute("female",countFemale);
		model.addAttribute("male",countAll -countFemale);
		model.addAttribute("countAcc", countAcc);
		model.addAttribute("countBus", countBus);
		model.addAttribute("countIt", countIt);
		model.addAttribute("countMan", countMan);
		model.addAttribute("countPer", countPer);
		return "depart";
	}
	@RequestMapping("staff")
	public String showAll(ModelMap model) {
		List<Staffs> list = staffService.findAll();
		model.addAttribute("staffs", list);
		return "staff";
	}


	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("staff", new StaffModel());
		return "add";
	}

	@GetMapping("update/{staffId}")
	public ModelAndView eidt(ModelMap model, @PathVariable("staffId") Long staffId) {
		
		Optional<Staffs> opt = staffService.findById(staffId);
		StaffModel staffm = new StaffModel();
		if (opt.isPresent()) {
			Staffs entity = opt.get();
			BeanUtils.copyProperties(entity, staffm);

			model.addAttribute("staff", staffm);
			
			return new ModelAndView("update", model);
		}
		model.addAttribute("Message", "Staff is not existed");
		return new ModelAndView("forward:/staff", model);
	}

	@PostMapping("save")
	public ModelAndView save(ModelMap model, @Valid @ModelAttribute("staff") StaffModel staff, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("errors", "Some thing is wrong! \n Please check again");
			return new ModelAndView("add", model);
		}
		if(!staff.getImage().isEmpty()) {
			
			
			String path = application.getRealPath("/");
			System.out.println(path);
			try {
				staff.setImageUrl(staff.getImage().getOriginalFilename());

				String filePath = path + "/images/" + staff.getImageUrl();
				
				staff.getImage().transferTo(Path.of(filePath));
				
				staff.setImage(null);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
			}
		else {
			model.addAttribute("errors", "Add image staff!");
			return new ModelAndView( "add", model);
		}
		Staffs entity = new Staffs();
		BeanUtils.copyProperties(staff, entity);
		staffService.save(entity);
		model.addAttribute("Message", "saved");
		return new ModelAndView("redirect:/staff", model);
	}
	
	
	@PostMapping("saveUpdate")
	public ModelAndView saveUpdate(ModelMap model, @Valid @ModelAttribute("staff") StaffModel staff, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("errors", "Some thing is wrong! \n Please check again");
			return new ModelAndView("update", model);
		}
		if(!staff.getImage().isEmpty()) {
			
			
			String path = application.getRealPath("/");
			System.out.println(path);
			try {
				staff.setImageUrl(staff.getImage().getOriginalFilename());

				String filePath = path + "/images/" + staff.getImageUrl();
				
				staff.getImage().transferTo(Path.of(filePath));
				
				staff.setImage(null);

			} catch (Exception e) {
				System.out.println(e.getMessage());
				}
			}
		else {
			model.addAttribute("errors", "Choose image staff");
			return new ModelAndView( "update", model) ;
		}
		Staffs entity = new Staffs();
		BeanUtils.copyProperties(staff, entity);
		staffService.save(entity);
		model.addAttribute("Message", "saved");
		return new ModelAndView("redirect:/staff", model);
	}
	@RequestMapping("record/{staffId}")
	public ModelAndView showRecord(ModelMap model, @PathVariable("staffId") Long staffId) {
		Optional<Staffs> opt = staffService.findById(staffId);
		StaffModel staffm= new StaffModel();
		if(opt.isPresent()) {
			Staffs entity = opt.get();
			BeanUtils.copyProperties(entity, staffm);
			model.addAttribute("record", new RecordModel());
			model.addAttribute("staff", staffm);
			model.addAttribute("id_staff", staffId);
			System.out.println(staffId);
			return new ModelAndView("record", model);
		}
		
		return new ModelAndView("record_search");
	}
	@PostMapping("save_record")
	public ModelAndView saveRecord(ModelMap model,@ModelAttribute("record") RecordModel record ) {
		
		Records entity= new Records();
		BeanUtils.copyProperties(record, entity);
		recordService.save(entity);
		model.addAttribute("message", entity);
		return new ModelAndView("redirect:/search_record", model);
	}
	
	
	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "fullName", required = false) String fullName) {
		List<Staffs> list = null;
		
		if (StringUtils.hasText(fullName)) {
			list = staffService.findByFullNameContaining(fullName);
			if(list.isEmpty()) {
				model.addAttribute("errors", "This staff is not exist");
				return "search";
			}
		} else {
			list = staffService.findAll();
		}
		model.addAttribute("staffs", list);
		return "search";
	}
	@GetMapping("search_record")
	public String searchRecord(ModelMap model, @RequestParam(name = "fullName", required = false) String fullName) {
		List<Staffs> list = null;

		if (StringUtils.hasText(fullName)) {
			list = staffService.findByFullNameContaining(fullName);
			if(list.isEmpty()) {
				model.addAttribute("errors", "This staff is not exist");
				return "search";
			}
		} else {
			list = staffService.findAll();
		}
		model.addAttribute("staffs", list);
		return "search_record";
	}

	@GetMapping("delete/{staffId}")
	public ModelAndView delete(ModelMap model, @PathVariable("staffId") Long staffId) {

		staffService.deleteById(staffId);
		model.addAttribute("message", "Staff is deleted");
		return new ModelAndView("forward:/staff", model);
	}

	@GetMapping("info/{staffId}")
	public ModelAndView showInfo(ModelMap model, @PathVariable("staffId") Long staffId) {
		Optional<Staffs> opt = staffService.findById(staffId);
		StaffModel staffm = new StaffModel();
		if (opt.isPresent()) {
			Staffs entity = opt.get();
			BeanUtils.copyProperties(entity, staffm);

			model.addAttribute("staff", staffm);
			return new ModelAndView("info", model);
		}
		model.addAttribute("Message", "Staff is not existed");
		return new ModelAndView("forward:/info", model);
	}
		
	@ModelAttribute(name = "DEPARTS")
	public List<Departs> getAllDepart(){
		return staffService.fillAllDeparts();
	}
}
