package br.com.transfinder.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StandardErrorSpring implements Serializable {

	private static final long serialVersionUID = 9172801720820158119L;

	private Long timestamp;
	private Integer status;
	private String error;
	private List<ErrorItem> validations = new ArrayList<>();
	private String message;
	private String path;

}
