package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class CartDAO {
   @Autowired
   private GoodsMapper mapper;
   
   /*
    *    // 장바구니 
	   @Insert("INSERT INTO busanCart(cno,gno,userid,accout) "
			  +"VALUES(bc_cno_seq.nextval,#{gno},#{userid},#{account})")
	   public void goodsCartInsert(CartVO vo);
	   
	   @Select("SELECT COUNT(*) FROM busanCart "
			  +"WHERE gno=#{gno} AND userid=#{userid}")
	   public int goodsCartGnoCount(CartVO vo);
	   
	   @Update("UPDATE busanCart SET "
			  +"account=account+#{account} "
			  +"WHERE gno=#{gno} "
			  +"AND userid=#{userid}")
	   public void goodsAccountUpdate(CartVO vo);
	   
	   @Results({
		   @Result(property = "gvo.goods_name",column = "goods_name"),
		   @Result(property = "gvo.goods_poster",column = "goods_poster"),
		   @Result(property = "gvo.goods_price",column = "goods_price")
	   })
	   @Select("SELECT cno,gno,account,isbuy,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
			  +"goods_name,goods_poster,goods_price "
			  +"FROM busanCart bc,goods_all ga "
			  +"WHERE bc.gno=ga.no "
			  +"AND userid=#{userid} AND isbuy=0 "
			  +"ORDER BY cno DESC")
	   public List<CartVO> goodsCartListData(String userid);
	   
	   // 구매내역 
	   @Results({
		   @Result(property = "gvo.goods_name",column = "goods_name"),
		   @Result(property = "gvo.goods_poster",column = "goods_poster"),
		   @Result(property = "gvo.goods_price",column = "goods_price")
	   })
	   @Select("SELECT cno,gno,account,isbuy,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
			  +"goods_name,goods_poster,goods_price "
			  +"FROM busanCart bc,goods_all ga "
			  +"WHERE bc.gno=ga.no "
			  +"AND userid=#{userid} AND isbuy=1 "
			  +"ORDER BY cno DESC")
	   public List<CartVO> goodsBuyListData(String userid);
	   
	   // 장바구니 취소 
	   @Delete("DELETE FROM busanCart "
			  +"WHERE cno=#{cno}")
	   public void goodsCartCancel(int cno);
	   
	   // 장바구니에서 구매 
	   @Update("UPDATE busanCart SET "
			  +"isbuy=1 "
			  +"WHERE cno=#{cno}")
	   public void goodsBuyUpdate(int cno);
    */
   public void goodsCartInsert(CartVO vo)
   {
	   mapper.goodsCartInsert(vo);
   }
   public int goodsCartGnoCount(CartVO vo)
   {
	   return mapper.goodsCartGnoCount(vo);
   }
   public void goodsAccountUpdate(CartVO vo)
   {
	   mapper.goodsAccountUpdate(vo);
   }
   public List<CartVO> goodsCartListData(String userid)
   {
	   return mapper.goodsCartListData(userid);
   }
   /*
    *  // 구매내역 
	   @Results({
		   @Result(property = "gvo.goods_name",column = "goods_name"),
		   @Result(property = "gvo.goods_poster",column = "goods_poster"),
		   @Result(property = "gvo.goods_price",column = "goods_price")
	   })
	   @Select("SELECT cno,gno,account,isbuy,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,"
			  +"goods_name,goods_poster,goods_price "
			  +"FROM busanCart bc,goods_all ga "
			  +"WHERE bc.gno=ga.no "
			  +"AND userid=#{userid} AND isbuy=1 "
			  +"ORDER BY cno DESC")
	   public List<CartVO> goodsBuyListData(String userid);
	   
	   // 장바구니 취소 
	   @Delete("DELETE FROM busanCart "
			  +"WHERE cno=#{cno}")
	   public void goodsCartCancel(int cno);
	   
	   // 장바구니에서 구매 
	   @Update("UPDATE busanCart SET "
			  +"isbuy=1 "
			  +"WHERE cno=#{cno}")
	   public void goodsBuyUpdate(int cno);
    */
   public List<CartVO> goodsBuyListData(String userid)
   {
	   return mapper.goodsBuyListData(userid);
   }
   public void goodsCartCancel(int cno)
   {
	   mapper.goodsCartCancel(cno);
   }
   public void goodsBuyUpdate(int cno)
   {
	   mapper.goodsBuyUpdate(cno);
   }
}
