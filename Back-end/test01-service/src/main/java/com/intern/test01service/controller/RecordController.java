package com.intern.test01service.controller;

import com.intern.test01service.dao.RecordRepository;
import com.intern.test01service.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/record")
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;

    @GetMapping(path = "/add")
    @ResponseBody
    public String addNewRecord(@RequestParam("code") String code, @RequestParam("message") String message) {
        Record record = new Record();
        record.setCode(Integer.parseInt(code));
        record.setMessage(message);
        recordRepository.save(record);
        return "Saved";
    }

    @GetMapping(path = "/all")
    @ResponseBody
    public Iterable<Record> getAllUsers() {
        return recordRepository.findAll(Sort.by("id"));
    }

    @GetMapping(path = "/byId")
    @ResponseBody
    public Record getUserById(@RequestParam("id") Integer id) {
        return recordRepository.findById(id).get();

    }

    @GetMapping(path = "/deleteById")
    @ResponseBody
    public void delUser(@RequestParam("id") Integer id) {
        recordRepository.deleteById(id);
    }

    @GetMapping(path = "/update")
    @ResponseBody
    public void update(@RequestParam("id") Integer id, @RequestParam("message") String message) {
        recordRepository.updateMessageById(id, message);
    }
}
