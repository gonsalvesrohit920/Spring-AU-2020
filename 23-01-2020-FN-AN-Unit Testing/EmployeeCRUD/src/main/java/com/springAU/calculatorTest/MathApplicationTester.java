package com.springAU.calculatorTest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
	
   @Mock
   CalculatorService calcService;

   @Test
   public void testAdd(){
      //add the behavior of calc service to add two numbers
      when(calcService.add(10.0,20.0)).thenReturn(30.00);
      when(calcService.subtract(20.0,10.0)).thenReturn(10.0);
      when(calcService.multiply(2.0, 3.0)).thenReturn(6.00);
      when(calcService.divide(2.0, 2.0)).thenReturn(1.00);
      when(calcService.power(2.0, 10.0)).thenReturn(1024.00);
		
      //test the add functionality
      Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);
      Assert.assertEquals(calcService.subtract(20.0, 10.0),10.0,0);
      Assert.assertEquals(calcService.multiply(2.0, 3.0),6.0,0);
      Assert.assertEquals(calcService.divide(2.0, 2.0),1.0,0);
      Assert.assertEquals(calcService.power(2.0, 10.0),1024.00,0);
       
      InOrder inOrder = inOrder(calcService);
      
      inOrder.verify(calcService).add(10.0,20.0);
      inOrder.verify(calcService).subtract(20.0,10.0);
      inOrder.verify(calcService).multiply(2.0, 3.0);
      inOrder.verify(calcService).divide(2.0, 2.0);
      inOrder.verify(calcService).power(2.0, 10.0);
   }
}