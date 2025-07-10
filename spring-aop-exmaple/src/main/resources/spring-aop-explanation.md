### Spring Aop
- Spring AOP provides a lightweight proxy-based approach to implementing AOP efficiently in enterprise applications .
- A simpler, proxy-based framework that integrates with the Spring Framework, using XML configurations or annotations to define aspects and pointcuts.

**Understanding AOP Concepts**
- **Aspect:** An Aspect is a modular unit of cross-cutting concerns(aspect). 
- For example, a logging aspect can be applied across various methods in different classes.
- **Advice:** This is the action taken by an aspect at a particular join point. There are five types of advice:
    - **Before:** Executed before the method call.
    - **After:** Executed after the method call, regardless of its outcome.
    - **AfterReturning:** Executed after the method returns a result, but not if an exception occurs.
    - **Around:** Surrounds the method execution, allowing you to control the method execution and its result.
    - **AfterThrowing:** Executed if the method throws an exception.
    - **Join Point:** A specific point in the execution of a program, such as method execution or exception handling, where an aspect can be applied.
    - **Pointcut:** A Pointcut is a predicate that defines where advice should be applied. It matches join points using expressions.


