package feuchtwanger.mco364.todo;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface TodoService {

	@GET("/todos")
	Call<List<Todo>> listTodos();
}
