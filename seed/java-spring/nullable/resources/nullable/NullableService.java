/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.nullable;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import resources.nullable.requests.CreateUserRequest;
import resources.nullable.requests.DeleteUserRequest;
import resources.nullable.types.User;

@RequestMapping(
    path = "/users"
)
public interface NullableService {
  @GetMapping(
      value = "",
      produces = "application/json"
  )
  List<User> getUsers(@RequestParam("usernames") Optional<String> usernames,
      @RequestParam("avatar") Optional<String> avatar,
      @RequestParam("activated") Optional<Boolean> activated,
      @RequestParam("tags") Optional<String> tags, @RequestParam("extra") Optional<Boolean> extra);

  @PostMapping(
      value = "",
      produces = "application/json",
      consumes = "application/json"
  )
  User createUser(@RequestBody CreateUserRequest body);

  @DeleteMapping(
      value = "",
      produces = "application/json",
      consumes = "application/json"
  )
  boolean deleteUser(@RequestBody DeleteUserRequest body);
}
