package br.com.damsete.arq.report.service;

import br.com.damsete.arq.report.model.Person;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class PersonService {

    public List<Person> findAll() {
        List<Person> list = newArrayList();
        for (int i = 1; i <= 30; i++) {
            Person p = new Person();
            p.setCpf("1000" + i);
            p.setEmail("pessoa" + i + "@mail.com");
            p.setAddress("Rua tal numero " + i);
            p.setAge(20 + i);
            p.setName("Pessoa" + i);
            p.setRg("081000" + i);
            list.add(p);
        }
        return list;
    }
}
