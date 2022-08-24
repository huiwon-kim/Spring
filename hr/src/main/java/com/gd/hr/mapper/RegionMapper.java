package com.gd.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Region;

@Mapper // >>> 알아서 클래스까지 만들어줌 
// --> @Repository public class ??? implements RegionMapper { ~ } 이런 형태!
// --> ??? 클래스의 객체를 가지고 메서드를 어쩌구...

public interface RegionMapper {
	List<Region> selectRegionList();
	
	int insertRegion(Region region); // 리전타입 받고 리전타입 입력
	
	int deleteRegion(int regionId); // 아디만 받으면 되니까

	int updateRegion(Region region);
}
