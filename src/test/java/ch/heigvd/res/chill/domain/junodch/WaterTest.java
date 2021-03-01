package ch.heigvd.res.chill.domain.junodch;

import ch.heigvd.res.chill.domain.Bartender;
import ch.heigvd.res.chill.domain.wasadigi.PunkIPA;
import ch.heigvd.res.chill.protocol.OrderRequest;
import ch.heigvd.res.chill.protocol.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterTest {

  @Test
  void thePriceAndNameForWaterShouldBeCorrect() {
    Water water = new Water();
    assertEquals(water.getName(), Water.NAME);
    assertEquals(water.getPrice(), Water.PRICE);
  }

  @Test
  void aBartenderShouldAcceptAnOrderForWater() {
    Bartender jane = new Bartender();
    String productName = "ch.heigvd.res.chill.domain.junodch.Water";
    OrderRequest request = new OrderRequest(3, productName);
    OrderResponse response = jane.order(request);
    BigDecimal expectedTotalPrice = Water.PRICE.multiply(new BigDecimal(3));
    assertEquals(expectedTotalPrice, response.getTotalPrice());
  }

}