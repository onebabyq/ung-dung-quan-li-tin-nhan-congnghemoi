package com.example.congnghemoi.converter;

import com.example.ChatWeb.dto.MessageDTO;
import com.example.ChatWeb.dto.UserDTO;
import com.example.congnghemoi.entity.Message;
import com.example.congnghemoi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;


@Component
public class MessageConverter {
	@Autowired
	AccountConverter accountConverter;
	public MessageDTO toDTO(Message entity) {
		MessageDTO result = new MessageDTO();
		result.setId(entity.getId());
		result.setContent(entity.getContent());
		result.setContentType(entity.getContentType());
		result.setCreateDate(entity.getCreateDate());
		result.setFrom(accountConverter.toDTO(entity.getFrom()));
		result.setReadStatus(entity.getReadStatus());
		result.setRoom(entity.getRoom());
		result.setFileName( convertFileName(result));
		return result;
	}
	public Message toEntity(MessageDTO dto) {
		Message result = new Message();
		result.setId(dto.getId());
		result.setContent(dto.getContent());
		result.setContentType(dto.getContentType());
		result.setCreateDate(dto.getCreateDate());
		result.setFrom(accountConverter.toEntity(dto.getFrom()));
		result.setReadStatus(dto.getReadStatus());
		result.setRoom(dto.getRoom());
		return result;
	}
	public String convertFileName(MessageDTO dto) {
			if (!dto.getContentType().equals("TEXT")) {
				return convertUrlToFileName(dto.getContent());
			}
			return null;
	}

	public static String convertUrlToFileName(String url) {
		File f = new File(url);
		return f.getName();
	}

}
