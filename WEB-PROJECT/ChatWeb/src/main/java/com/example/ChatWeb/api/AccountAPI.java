package com.example.ChatWeb.api;

import com.example.ChatWeb.dto.AccountDTO;
import com.example.ChatWeb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/accounts")
public class AccountAPI {
    @Autowired
    private AccountService accountService;
    @GetMapping("/rooms/{id}")
    public List<AccountDTO> getListAccountInRoomById(@PathVariable long id){
        List<AccountDTO> listAccountDTO = accountService.getListAccountInRoomById(id);

        return listAccountDTO;
    }
    @GetMapping("/rooms/{id}/getAdmin")
    public AccountDTO getAdmin(@PathVariable Long id){
        AccountDTO dto = accountService.getAdminInRoomById(id);
        System.out.println(dto.toString());
        return dto;
    }
}

