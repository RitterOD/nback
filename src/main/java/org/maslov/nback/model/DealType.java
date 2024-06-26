package org.maslov.nback.model;

public enum DealType {
  ONE(1L),
  TWO(2L),
  THREE(3L),
  FOUR(4L),
  FIVE(5L),
  SIX(6L),
  SEVEN(7L),
  EIGHT(8L),
  NINE(9L),
  TEN(10L),
  ELEVEN(11L),
  TWELVE(12L),
  THIRTEEN(13L),
  FOURTEEN(14L),
  FIFTEEN(15L),
  SIXTEEN(16L),
  SEVENTEEN(17L),
  EIGHTEEN(18L),
  NINETEEN(19L),
  TWENTY(20L);


  DealType(Long number) {
    this.number = number;
  }

  private Long number;

}
