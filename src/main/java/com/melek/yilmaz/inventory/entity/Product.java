package com.melek.yilmaz.inventory.entity;



//oluşturulan sınıfı persistence dosyasında provider etiketinin kapandığı yerden itibaren class etiketiyle tanımla

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Product {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private String _productName;
  private double _salesPrice;
  private long _productId;

  public Product() {}

  public Product(String productName, double salesPrice, long productId) {
      _productName=productName;
      _salesPrice=salesPrice;
      _productId=productId;

  }

  public String getProductName(String productName) {
      return productName;
  }

  public void setProductName(String productName) {
      this._productName=productName;
  }



  public double getSalesPrice(double salesPrice) {
      return salesPrice;

  }

  public void setSalesPrice(double salesPrice) {
      this._salesPrice=salesPrice;
  }



  public Product getProductId(Product product) {
      return product;
  }

  public void setProductId(long productId) {
      this._productId=productId;
  }


}