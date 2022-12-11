package vendingmachine.util;

import vendingmachine.repository.VendingMachineRepository;

import java.util.List;
import java.util.regex.Pattern;

import static vendingmachine.util.TransformInput.transformFormat;

public class InputValidator {
    private final static int UNIT = 10;
    private final static int INPUT_SIZE = 3;
    private final static int MIN_RANGE_NUM = 10;
    private final static int MIN_PRICE = 100;
    private final static String INVALID_UNIT_ERROR_MESSAGE = "[ERROR] 10으로 나누어 떨어지는 숫자여야 합니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자로만 이루어진 값을 입력해주세요.";
    private final static String AMOUNT_RANGE_ERROR_MESSAGE = "[ERROR] 10이상 숫자를 입력해주세요.";
    private final static String PRICE_RANGE_ERROR_MESSAGE = "[ERROR] 100이상 숫자를 입력해주세요.";
    private final static String INVALID_FORMAT_ERROR_MESSAGE = "[ERROR] 올바른 형식의 값이 아닙니다.";
    private final static String NON_EXIST_PRODUCT_ERROR_MESSAGE = "[ERROR] 존재하지 않는 상품입니다.";
    private final static String OUT_OF_SIZE_ERROR_MESSAGE = "[ERROR] 상품명, 가격, 수량 총 3가지를 입력해주세요.";

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

    public static void validatePriceRange(int input) {
        if (input < MIN_PRICE) {
            throw new IllegalArgumentException(PRICE_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateProduct(String input) {
        String[] products = input.split(";");
        for (String product : products) {
            validateProductFormat(product);
            List<String> transformProduct = transformFormat(product);
            validateSize(transformProduct);
            validateNonNumeric(transformProduct.get(1));
            validateNonNumeric(transformProduct.get(2));
            validatePriceRange(Integer.parseInt(transformProduct.get(1)));
            validateUnit(Integer.parseInt(transformProduct.get(1)));
        }
    }

    private static void validateSize(List<String> input) {
        if (input.size() != INPUT_SIZE) {
            throw new IllegalArgumentException(OUT_OF_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateProductFormat(String input) {
//        String pattern = "^[ + ]$";
//        if (!Pattern.matches(pattern, input)) {
//            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MESSAGE);
//        }
        if (!input.startsWith("[") && !input.endsWith("]")) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateExistProduct(String input) {
        if (!VendingMachineRepository.isExistProduct(input)) {
            throw new IllegalArgumentException(NON_EXIST_PRODUCT_ERROR_MESSAGE);
        }
    }
}
