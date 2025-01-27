/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.singleproperty;

import java.lang.Boolean;
import java.lang.String;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(
    path = "/"
)
public interface SinglePropertyService {
  @GetMapping(
      value = "/{id}",
      produces = "application/json"
  )
  String doThing(@PathVariable("id") String id,
      @RequestParam("include-remote-data") Optional<Boolean> includeRemoteData);
}
