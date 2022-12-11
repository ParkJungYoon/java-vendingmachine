package vendingmachine.util;

import vendingmachine.repository.VendingMachineRepository;

import java.util.regex.Pattern;

public class InputValidator {
    private final static int UNIT = 10;
    private final static int MIN_RANGE_NUM = 10;
    private final static String INVALID_UNIT_ERROR_MESSAGE = "[ERROR] 10으로 나누어 떨어지는 숫자여야 합니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자로만 이루어진 값을 입력해주세요.";
    private final static String AMOUNT_RANGE_ERROR_MESSAGE = "[ERROR] 10이상 숫자를 입력해주세요.";
    private final static String INVALID_FORMAT_ERROR_MESSAGE = "[ERROR] 올바른 형식의 값이 아닙니다.";
    private final static String NON_EXIST_PRODUCT_ERROR_MESSAGE = "[ERROR] 존재하지 않는 상품입니다.";

    public static void validateNonNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
    }

    public static void validateUnit(int input) {
        if (input % UNIT != 0) {
            throw new IllegalArgumentException(INVALID_UNIT_ERROR_MESSAGE);
        }
    }

    public static void validateAmountRange(int input) {
        if (input < MIN_RANGE_NUM) {
            throw new IllegalArgumentException(AMOUNT_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateProduct(String input) {
        String[] products = input.split(";");
        for (String product : products) {
//            validateProductFormat(product);

        }
    }

    private static void validateProductFormat(String input) {
        String pattern = "[ + ]$";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateExistProduct(String input) {
        if (!VendingMachineRepository.isExistProduct(input)) {
            throw new IllegalArgumentException(NON_EXIST_PRODUCT_ERROR_MESSAGE);
        }
    }
}
