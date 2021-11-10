package bankcustomerdetails.errordetails;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ErrorMessageMapper {
/*implements ExceptionMapper<ErrorMessage>{

	public Response toResponse(ErrorMessage exception) {
		Message message = new Message(exception.getMessage(), "404", "Update Later");
		return Response.status(Status.NOT_FOUND)
				.entity(message)
				.build();
	}*/

}
