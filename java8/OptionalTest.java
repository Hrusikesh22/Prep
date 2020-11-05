package java8;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		//System.out.println(returnNull().toString()); //NPE
		System.out.println(returnOptinalNull()); //NPE
		System.out.println(returnActualnOptinalNull()); //Optional.empty
		System.out.println(returnActualnOptinalNull().toString()); //No NPE, Optional.empty
		System.out.println(returnActualnOptinalNull().isPresent()); //No NPE, false
	}

	public static String returnNull() {
		return null;
	}

	public static Optional<String> returnOptinalNull() {
		return null;
	}

	public static Optional<String> returnActualnOptinalNull() {
		//return Optional.of("not_null_value, null can't be set with Optional.of(), for that we have Optional.ofNullable()");
		return Optional.ofNullable(null);
	}
}

/*
 * Intended usage : someOptional.flatMap(SomeClass::someMethodReturningOptional).flatMap(OtherClass::otherMethodReturningOptional).ifPresent(YetAnotherClass::yetAnotherMethod)
 * 					 
*/