package it.cb.biblioteca.utils;

import it.cb.biblioteca.dto.UtenteDto;
import it.cb.biblioteca.model.UtenteVo;

public class UtenteUtils {
public static UtenteVo fromDtoToVo(UtenteDto dto) {
	UtenteVo vo = new UtenteVo();
	vo.setUsername(dto.getUsername());
	return vo;
}
public static UtenteDto fromVoToDto(UtenteVo vo) {
	UtenteDto dto = new UtenteDto();
	dto.setUsername(vo.getUsername());
	dto.setPassword(vo.getPassword());
	dto.setNome(vo.getNome());
	dto.setCognome(vo.getCognome());
	dto.setCf(vo.getCf());
	
	return dto;
}

}
