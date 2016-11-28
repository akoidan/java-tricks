package oct2016.patterns.chain_of_responsobility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by andrew on 11/28/16.
 */
@AllArgsConstructor
@Getter
@Setter
public class Request {
    int n1;
    int n2;
    private char calculationWanted;

}
