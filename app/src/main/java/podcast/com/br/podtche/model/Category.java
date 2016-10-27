package podcast.com.br.podtche.model;

import java.io.Serializable;

/**
 * Created by filipenunes on 9/22/16.
 */
public class Category implements Serializable {

    public static final String ALL = "Tudo";

    public long id;
    public String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, long id){
        this.name = name;
        this.id = id;
    }



    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Category) {
            final Category category = (Category) o;
            return name.equals(category.name);
        }

        return super.equals(o);
    }
}
