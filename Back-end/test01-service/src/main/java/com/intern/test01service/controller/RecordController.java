package com.intern.test01service.controller;

import com.intern.test01service.dao.RecordRepository;
import com.intern.test01service.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/record")
@RefreshScope
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;

    @GetMapping(path = "/add")
    public String addNewRecord(@RequestParam("code") String code, @RequestParam("message") String message) {
        Record record = new Record();
        record.setCode(Integer.parseInt(code));
        record.setMessage(message);
        recordRepository.save(record);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public Iterable<Record> getAllUsers() {
        return recordRepository.findAll(Sort.by("id"));
    }

    @GetMapping(path = "/byId")
    public Record getUserById(@RequestParam("id") Integer id) {
        return recordRepository.findById(id).get();

    }

    @GetMapping(path = "/deleteById")
    public void delUser(@RequestParam("id") Integer id) {
        recordRepository.deleteById(id);
    }

    @GetMapping(path = "/update")
    public void update(@RequestParam("id") Integer id, @RequestParam("message") String message) {
        recordRepository.updateMessageById(id, message);
    }
}
