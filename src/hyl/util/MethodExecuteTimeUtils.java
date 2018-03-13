package hyl.util;

import java.lang.reflect.Method;

public class MethodExecuteTimeUtils {
	
	   public static long getMethodExecuteTime(Object bean, Object[] params, String methodName, Class<?>[] types)
	            throws Exception {
	        return getMethodExecuteTime(bean, params, methodName, types, false, false);
	    }

	    public static long getMethodExecuteTime(Object bean, Object[] params, String methodName,
	            Class<?>[] types, boolean isPrintExecutetime) throws Exception {
	        return getMethodExecuteTime(bean, params, methodName, types, isPrintExecutetime, false);
	    }


	    public static long getMethodExecuteTime(Object bean, Object[] params, String methodName,
	            Class<?>[] types, boolean isPrintExecutetime, boolean isViewMehtodResult) throws Exception {
	        Class<?> clazz;
	        long executeTime = -1L;
	        boolean isAccessiable = false;
	        Method method = null;
	        if (bean instanceof Class<?>) {
	            clazz = (Class<?>) bean;
	        } else {
	            clazz = bean.getClass();
	        }
	        try {
	            if (types == null) {
	                method = clazz.getDeclaredMethod(methodName);
	            } else {
	                method = clazz.getDeclaredMethod(methodName, types);
	            }
	            isAccessiable = method.isAccessible();
	            if (!isAccessiable) {
	                method.setAccessible(true);
	            }

	            if (isViewMehtodResult) {
	                executeTime = getReturnMethodExecuteTime(bean, params, method);
	            } else {
	                executeTime = getMethodExecuteTime(bean, params, method);
	            }
	            method.setAccessible(isAccessiable);
	            if (isPrintExecutetime) {
	                printExecute(clazz, methodName, executeTime);
	            }
	        } catch (Exception e) {
	            throw new Exception("excute method fail");
	        }
	        return executeTime;
	    }

	    private static long getMethodExecuteTime(Object bean, Object[] params, Method method) throws Exception {
	        long startTime = System.nanoTime();
	        method.invoke(bean, params);
	        long endTime = System.nanoTime();
	        return (endTime - startTime)/1000;
	    }


	    private static long getReturnMethodExecuteTime(Object bean, Object[] params, Method method)
	            throws Exception {
	        long startTime = System.currentTimeMillis();
	        Object result = (Object) method.invoke(bean, params);
	        long endTime = System.currentTimeMillis();
	        if (result != null) {
	            System.out.println("result input：" + result.toString());
	        } else {
	            System.out.println("Warning:" + bean.getClass().getName() + "." + method.getName()
	                    + "has not return " + "result,please setting the isViewMehtodResult as false");
	        }
	        return endTime - startTime;
	    }

	    public static void printExecute(Class<?> clazz, String methodName, long time) {
	        System.out.println(clazz.getName() + "." + methodName + " 耗时: " + time +"微妙");
	    }
}
