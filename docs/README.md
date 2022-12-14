## 자판기 (박정윤) 
- 반환되는 동전이 최소한이 되는 자판기

### 🚩 기능 구현 목록 

### 기능 프로세스
- [x] <입력> 자판기가 보유하고 있는 금액
  - [x] `예외처리`
    - [x] 숫자가 아닌 경우
    - [x] 10보다 작은 숫자가 들어온 경우
    - [x] 10으로 나누어 떨어지지 않는 경우
- [x] <출력> 자판기가 보유한 동전
- [x] <입력> 상품명과 가격, 수량 
  - 상품 등록  
  - [x] `예외처리`
    - [x] 세미콜론(;)으로 구분해서 올바른 형식으로 들어오지 않았을 경우
    - [x] 값이 3개씩 안들어온 경우
    - [x] 상품 가격과 수량이 숫자가 아닌 경우
    - [x] 상품 가격이 100보다 작은 경우
    - [x] 상품 가격이 10으로 나누어 떨어지지 않는 경우
- [x] <입력> 투입 금액
  - [x] `예외처리`
    - [x] 숫자가 아닌 경우
    - [x] 10보다 작은 경우
    - [x] 10으로 나누어떨어지지 않는 경우
- [x] <입력> 구매할 상품명 * 반복 *
  - (종료 조건) 잔돈이 가장 저렴한 상품보다 적으면 종료, 모든 상품 소진 시 종료
  - [x] `예외처리`
    - [x] 등록된 상품이 아닌 경우
- [x] <출력> 잔돈은 반환된 동전만

### 동전 생성하는 기능
- 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성
  - 투입 금액 제외 (ex. 500원 보유 -> 500원 1개 안됨)

### 상품을 구매하는 기능
- 잔돈을 돌려줄 때 현재 보유한 최소 개수의 동전으로
- 지폐를 잔돈으로 반환하는 경우는 없다
- 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
- 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환
  - 반환되지 않은 금액은 자판기에 남는다.

### 예외처리
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 다시 입력을 받는다.
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR]로 시작해야 한다.
```
[ERROR] 금액은 숫자여야 합니다.
```

###  📚 폴더 구조

```
├─main
│  └─java
│      └─vendingmachine
│          │  Application.java
│          │
│          ├─controller
│          │      VendingMachineController.java
│          │
│          ├─domain
│          │      Coin.java
│          │      GenerateCoins.java
│          │      GenerateCoinsImpl.java
│          │
│          ├─repository
│          │      CoinRepository.java
│          │      VendingMachineRepository.java
│          │
│          ├─util
│          │      InputValidator.java
│          │      TransformInput.java
│          │
│          └─view
│                  InputView.java
│                  OutputView.java
│
└─test
    └─java
        └─vendingmachine
                ApplicationTest.java
```