package com.jetbrains.debugging;

import com.jetbrains.entity.OrderItem;
import com.jetbrains.entity.Product;
import com.jetbrains.inspections.CollectionsFactoryMethods;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

@SuppressWarnings("ALL")
public class DebuggingTest {
    @Test
    public void shouldRenderPrimitiveTypes() {
        UnderTest underTest = new UnderTest();
        underTest.doSomething();

        System.out.println(underTest.getWords());
    }

    @Test
    public void shouldShowChangingValues() {
        UnderTest underTest = new UnderTest();
        underTest.doSomething();

        CollectionsFactoryMethods collectionsFactoryMethods = new CollectionsFactoryMethods();

        IgnoreException ignoreException = new IgnoreException();

        UnderTest anotherUnderTest = new UnderTest();

        InlineDebugging inlineDebugging = new InlineDebugging();
    }

    @Test
    public void shouldOnlyRenderOnDemandRendererWhenClicked() {
        final OrderItem orderItem = new OrderItem(4738, 2);

        final Product product = new Product(43789, "Book",
                new BigDecimal("15.99"), List.of(orderItem));

        System.out.println(product);
    }

    @Test
    public void shouldTriggerAnExceptionBreakpoint() {
        UnderTest underTest = new UnderTest();
        underTest.catchesCustomException();
    }

    @Test
    public void shouldNotTriggerAnExceptionBreakpoint() {
        IgnoreException ignoreException = new IgnoreException();
        ignoreException.catchesCustomException();
    }

    @Test
    public void shouldRunUsingADifferentJVM() {
        InlineDebugging forDebugging = new InlineDebugging();
        forDebugging.run();
    }

    private class UnderTest {
        private int someValue = 2;
        private AnotherClass anotherClass = new AnotherClass();
        private String[] words = {"This", "is", "an", "array", "of", "Strings"};
        private int[] integers = {1, 1, 2, 3, 5};

        private void doSomething() {
            someValue++;
        }

        public String[] getWords() {
            return words;
        }

        public void catchesCustomException() {
            try {
                anotherClass.throwException();
            } catch (CustomException e) {
                e.printStackTrace();
            }
        }
    }

    private class IgnoreException {
        private AnotherClass obj = new AnotherClass();
        private void catchesCustomException() {
            try {
                obj.throwException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private class AnotherClass {
        private String value = "The Value";
        public void throwException() {
            throw new CustomException();
        }
    }

    private class CustomException extends RuntimeException {
    }
}