package br.com.gabrielmteixeira.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Utils {

  public static void copyNonNullProperties(Object source, Object target) {
    // copyProperties() copies the properties of one object to another
    // The third parameter is the "rule" it will follow to do so
    // In this case, it will copy the properties which the name is present in the String array returned by getNullPropertyNames(source)
    // getNullPropertyNames(source) will return a String array with the names of all null properties in "source" object
    BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
  }

  public static String[] getNullPropertyNames(Object source) {
    // BeanWrapper is an interface with methods to access the attributes of an object in Java
    // BeanWrapperImpl is the implementation of that interface
    final BeanWrapper src = new BeanWrapperImpl(source);

    PropertyDescriptor[] pds = src.getPropertyDescriptors();

    Set<String> emptyNames = new HashSet<>();

    for(PropertyDescriptor pd: pds) {
      Object srcValue = src.getPropertyValue(pd.getName());
      if (srcValue == null) {
        emptyNames.add((pd.getName()));
      }
    }

    String[] result = new String[emptyNames.size()];
    return emptyNames.toArray(result);
  }
}
