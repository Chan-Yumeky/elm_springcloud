package ynu.jackielinn.cart.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ynu.jackielinn.cart.dto.response.CartQuantityVO;
import ynu.jackielinn.cart.entity.Cart;

import java.util.List;

@Mapper
public interface CartMapper extends BaseMapper<Cart> {

    @Select("SELECT businessId, SUM(quantity) as quantity " +
            "FROM cart " +
            "WHERE userId = #{userId} " +
            "GROUP BY businessId")
    List<CartQuantityVO> getCartQuantityByUserId(Long userId);
}
