package com.gd.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Region;


@Service
@Transactional
public class IRegionSerivice implements RegionService {
	// 이제 주입받아야지 
	// Dependency Injection(DI); 객체를 직접생성하지 않고 스프링프레임워크를 통해(bean)객체를 주입받는다
	//			┌ 생략ㅇ		인터페이스 형태로 주입받겠다
	@Autowired private RegionMapper regionMapper;
	// ∴ Interface 타입을 사용하겠다 (디커플링 하려구)
	// 만약 오토와이어드 리전매퍼하는데 실제 리전매퍼에 @Mapper가 없으면 주입할 수 없다고 오류 뜬다! ※주의
	
	@Override
	public List<Region> getRegionList() {
		
		return regionMapper.selectRegionList();
	}

	@Override
	public int addRegion(Region region) {
		// 그대로 리턴한대
		return regionMapper.insertRegion(region);
	}

	@Override
	public int removeRegion(int regionId) {
		
		return regionMapper.deleteRegion(regionId);
	}

	@Override
	public int modifyRegion(Region region) {
		
		return regionMapper.updateRegion(region);
	}

}
