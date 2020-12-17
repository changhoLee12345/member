package co.syeon.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BorderCommand {
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
	
}
