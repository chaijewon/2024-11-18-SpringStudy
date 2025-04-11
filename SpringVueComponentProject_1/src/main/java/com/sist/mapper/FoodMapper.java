package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
   /*
    *   <select id="foodFindData" resultType="FoodVO" 
        parameterType="hashmap">
    */
	@Select("<script>"
		   +"SELECT fno,poster,name,num"
		   + "    FROM (SELECT fno,poster,name,rownum as num "
		   + "    FROM (SELECT fno,poster,name"
		   + "    FROM project_food "
		   + "    WHERE "
		   + "      <trim prefix=\"(\" suffix=\")\" prefixOverrides=\"OR\">"
		   + "        <foreach collection=\"fdArr\" item=\"fd\">"
		   + "         <trim prefix=\"OR\">"
		   + "          <choose>"
		   + "            <when test=\"fd=='N'.toString()\">"
		   + "              name LIKE '%'||#{ss}||'%'"
		   + "            </when>"
		   + "            <when test=\"fd=='A'.toString()\">"
		   + "              address LIKE '%'||#{ss}||'%'"
		   + "            </when>"
		   + "            <when test=\"fd=='T'.toString()\">"
		   + "              type LIKE '%'||#{ss}||'%'"
		   + "            </when>"
		   + "            <when test=\"fd=='M'.toString()\">"
		   + "              theme LIKE '%'||#{ss}||'%'"
		   + "            </when>"
		   + "          </choose>"
		   + "         </trim>"
		   + "        </foreach>"
		   + "      </trim>"
		   + "      "
		   + "      ORDER BY fno ASC"
		   + "    ))"
		   + "    WHERE num BETWEEN #{start} AND #{end}"
		   +"</script>")
	public List<FoodVO> foodFindData(Map map);
}
