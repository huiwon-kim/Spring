package com.gd.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.IRegionSerivice;
import com.gd.hr.vo.Region;

@Controller // 객체만들어지는데 서블릿 객체임 >>> 서블릿 쓰던거 사용 ㅇ
public class RegionController {
	//@RequestMapping(method=POST) <<<- 이런식으로 써도 됨
	//@RequestMapping <<< 겟셋 하나로 처리해야할 때
	
	
	
	@Autowired IRegionSerivice iregionService; // iregionService로 리턴할거고 실제 주입 new RegionService()
	
	
	
	@GetMapping("/regionList") // 요청처리하는 메서드 (1)
	public String regionList(Model model) {// >>> 뷰 이름만 리턴 & 모델을 따로 넣어야 >>> 모델을 매개변수로 받아야
				// └(2)
	
		List<Region> list = iregionService.getRegionList();
		model.addAttribute("list", list); // requesg.setAttribute("list", list); 와 같은 여갛ㄹ
	
		System.out.println(list);	
		return "regionList"; // ("regionList").forward(request, response); 와 같다
	//			└(3)
	// (1), (2), (3) 다 같은 이름 쓰는게 안헷갈리고 또 많이드 쓰는 방법이래
	
	// Cf) public ModelAndView >> 뷰와 모델 같이 리턴
		
	
		
	}
	
	
	
	// 매핑이 중복되면 컨트롤러클래스가 완성이 ㅏㅇㄴ됨 >>> 부트가 안됨 >> 제일 ㅓㅁㄴ저 확인하래. 근데 같아도 매핑이 겟 포스트면 다른듯
	// 왜 Form, Action의 메서드이름이 같은데 괜찮지? 파라미터가 달라서 >>> 오버로딩
	@GetMapping("/addRegion") // Form
	public String addRegion() {
		return "addRegion";
		
	}
	
	
	
	@PostMapping("/addRegion") // Action						┌ 이러면 nul이면 1로 자동셋팅이래
	//public String addRegion(@RequestParam(value="regionId", defaultValue = "1") int regionId) {
	// 		 └int regionId = request.getParameter("regionId") 와 같대. 왜냐면 스프링은 자동으로 형변환 해준대 !
	public String addRegion(Region region) {// 34번과 36번이 같은거래. form만들때 네임이 동일하면 이렇게 호출딘대
		System.out.println(region);
		
		int row = iregionService.addRegion(region);
		System.out.println(row +"<-row값");
		
		return "redirect:/regionList"; // regionList로 redirect
	}
	
	
	
	
	@GetMapping("/removeRegion")	
	public String removeRegion (@RequestParam(value="regionId") int regionId) {
		//removeRegion (@RequestParam(value="regionId", reguired=false) 널갑 ㅅ허용
		int row = iregionService.removeRegion(regionId);
		System.out.println(row +"<-row 값");
		return "redirect:/regionList";
	}	
	

	
	
	@GetMapping("/modifyRegion")
	public String modifyRegion(Model model, Region region) {	
		model.addAttribute("r", region);
		return "modifyRegion";
	}
	
	
	@PostMapping("/modifyRegion")
	public String modifyRegion(Region region) {
		int row = iregionService.modifyRegion(region);
		System.out.println(row+"<-row 값");
		return "redirect:/regionList";
}

}