package co.syeon.notice.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NoticeFileDown.do")
public class NoticeFileDownController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeFileDownController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileName = request.getParameter("fileName");

		// 서버에 올라간 경로 가져옴
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath("uploadFile");
		String filePath = uploadFilePath + File.separator + fileName;

		System.out.println(" LOG [업로드된 파일 경로] :: " + uploadFilePath);
		System.out.println(" LOG [파일 전체 경로] :: " + filePath);

		byte[] b = new byte[4096];
		FileInputStream fileInputStream = new FileInputStream(filePath);
		
		// page의 contentType 등을 동적으로 바꾸기 위해 초기화시킴.
		String mimeType = getServletContext().getMimeType(filePath);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);

		// 파일명 UTF-8로 인코딩(한글일 경우를 대비)
		String sEncoding = new String(fileName.getBytes("UTF-8"));
		response.setHeader("Content-Disposition", "attachment; fileName=" + sEncoding);

		// 파일 쓰기 OutputStream
		ServletOutputStream servletOutStream = response.getOutputStream();

		int read;
		while ((read = fileInputStream.read(b, 0, b.length)) != -1) {
			servletOutStream.write(b, 0, read);
		}

		servletOutStream.flush();
		servletOutStream.close();
		fileInputStream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
