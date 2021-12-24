package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicecars.domains.Brand;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BrandRequest implements Serializable {

    private static final long serialVersionUID = 3475925051912891191L;

    @ApiModelProperty(position = 1)
    @NotNull(message = "{required.field}")
    private Boolean imported;

    @ApiModelProperty(position = 2)
    @NotNull(message = "{required.field}")
    private String name;

    public Brand toDomain(){
        return Brand.builder()
                .imported(this.imported)
                .name(this.name)
                .build();
    }
}
