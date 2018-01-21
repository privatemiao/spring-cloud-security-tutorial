package org.mel.springcloudsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    private Map<Long, Employee> employeeMap = new HashMap<>();

    @Qualifier("oauth2ClientContext")
    @Autowired
    private OAuth2ClientContext context;

    @GetMapping("/emp")
    public Collection<Employee> getEmployee() {
        if (ObjectUtils.isEmpty(employeeMap)) {
            employeeMap.put(1L, new Employee(1L, "mel", 35, "Suzhou"));
            employeeMap.put(2L, new Employee(1L, "shine", 33, "Binhai"));
            employeeMap.put(3L, new Employee(1L, "john", 12, "Nanjing"));
            employeeMap.put(4L, new Employee(1L, "jack", 22, "Shanghai"));
        }

        return employeeMap.values();
    }

    @GetMapping("/api/token")
    public String getToken() {
        return context.getAccessToken().getValue();
    }

    @GetMapping("/api/emp/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeMap.get(id);
    }
}