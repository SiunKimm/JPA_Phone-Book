package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BaseTimeEntity;
import com.example.demo.entity.Friend;
import com.example.demo.entity.Phone;
import com.example.demo.repository.FriendRepository;
import com.example.demo.repository.PhoneRepository;

@RestController
public class JpaController {
	
	@Autowired
	FriendRepository repository;

	@Autowired
	PhoneRepository repository2;

	@GetMapping("/")
	public String getMainPage() {
		return "This is the JPA test page";
	}

	@GetMapping("/findall")
	public String findAll(Model model) throws Exception {
		
		model.addAttribute("list", repository.findAll());
		return "list";
	}

	@GetMapping("/telall")
	public String telAll() {
		String result = "";

		for (Phone phone : repository2.findAll()) {
			result += phone.toString() + "</br>";
		}

		return result;
	}

	@GetMapping("/detail")
	public String findById(Model model, @RequestParam("frndSeq") long frndSeq) {

		String numbers = "";

		Friend member = repository.findById(frndSeq).get(0);
		for (Phone phone : member.getPhones()) {
			numbers += phone.getTelNo1() + "</br>" + phone.getTelNo2() + "</br>" + phone.getTelNo3() + "</br>";

			model.addAttribute("p1", phone.getTelNo1());
			model.addAttribute("p2", phone.getTelNo2());
			model.addAttribute("p3", phone.getTelNo3());
		}
		return numbers;
	}

	@GetMapping("/add")
	public String addMember(@RequestParam("frnd_nm") String frndNm, @RequestParam("tel_type") String telType,
			@RequestParam("tel_no_1") String telNo1, @RequestParam("tel_no_2") String telNo2,
			@RequestParam("tel_no_3") String telNo3) {
		Friend member = new Friend(frndNm);
		repository.save(member);
		Phone phone = new Phone(telType, telNo1, telNo2, telNo3);
		phone.setFriend(member);
		repository2.save(phone);
		return "Addition done!";
	}

	@GetMapping("/update")
	public String updateMember(@RequestParam("frndSeq") long frndSeq, @RequestParam("frnd_nm") String frndNm) {

		Friend member = repository.findById(frndSeq).get(0);

		member.setFrndNm(frndNm);
		repository.save(member);

		return "Update done!";
	}

	/*
	 * @GetMapping ("/delete") public String deleteMember(
	 * 
	 * @RequestParam("frnd_seq") long frndSeq) {
	 * 
	 * repository.deleteById(frndSeq);
	 * 
	 * return "redirect:/jsp/list"; }
	 */

	/*
	 * @GetMapping ("/ddelete") public String ddeleteMember(
	 * 
	 * @RequestParam("tel_seq") long telSeq) {
	 * 
	 * repository2.deleteById(telSeq);
	 * 
	 * return "done!"; }
	 */

	@GetMapping("/findbycreatedate")
	private String findByRegDtm(@RequestParam("regdtm") LocalDateTime createdDate) {
		String result = "";

		for (BaseTimeEntity member : repository.findByRegDtm(createdDate)) {
			result += member.toString() + "</br>";
		}

		return result;
	}

	@GetMapping("/findbymodifieddate")
	private String findByModDtm(@RequestParam("moddtm") LocalDateTime modifiedDate) {
		String result = "";

		for (BaseTimeEntity member : repository.findByModDtm(modifiedDate)) {
			result += member.toString() + "</br>";
		}

		return result;
	}

	@GetMapping("/ffindbyid")
	public String ffindById(@RequestParam("tel_Seq") long telSeq) {
		String result = "";

		for (Phone phone : repository2.findById(telSeq)) {
			result += phone.toString() + "</br>";
		}

		return result;
	}

	@GetMapping("/aadd")
	public String addPhone(@RequestParam("tel_type") String telType, @RequestParam("tel_no_1") String telNo1,
			@RequestParam("tel_no_2") String telNo2, @RequestParam("tel_no_3") String telNo3) {

		repository2.save(new Phone(telType, telNo1, telNo2, telNo3));

		return "Addition done!";
	}

	@GetMapping("/uupdate")
	public String updatePhone(@RequestParam("tel_seq") long telSeq, @RequestParam("tel_type") String telType,
			@RequestParam("tel_no_1") String telNo1, @RequestParam("tel_no_2") String telNo2,
			@RequestParam("tel_no_3") String telNo3) {

		Phone phone = repository2.findById(telSeq).get(0);

		phone.setTelType(telType);
		phone.setTelNo1(telNo1);
		phone.setTelNo2(telNo2);
		phone.setTelNo3(telNo3);

		repository2.save(phone);

		return "Update done!";
	}

	@GetMapping("/ffindbycreatedate")
	private String ffindByRegDtm(@RequestParam("regdtm") LocalDateTime createdDate) {
		String result = "";

		for (BaseTimeEntity phone : repository2.findByRegDtm(createdDate)) {
			result += phone.toString() + "</br>";
		}

		return result;
	}

	@GetMapping("/ffindbymodifieddate")
	private String ffindByModDtm(@RequestParam("moddtm") LocalDateTime modifiedDate) {
		String result = "";

		for (BaseTimeEntity phone : repository2.findByModDtm(modifiedDate)) {
			result += phone.toString() + "</br>";
		}

		return result;
	}

}
