/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.union;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import resources.union.types.Metadata;
import resources.union.types.MyUnion;

@RequestMapping(
    path = "/"
)
public interface UnionService {
  @PostMapping(
      value = "",
      produces = "application/json",
      consumes = "application/json"
  )
  MyUnion get(@RequestBody MyUnion body);

  @GetMapping(
      value = "/metadata",
      produces = "application/json"
  )
  Metadata getMetadata();
}
