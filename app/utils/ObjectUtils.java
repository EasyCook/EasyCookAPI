package utils;

import java.lang.reflect.Field;

/**
 * Created by eduardo on 21/11/14.
 */
public class ObjectUtils<T, N>
{

    Class<T> original;
    Class<N> dto;

    public ObjectUtils(Class<T> original, Class<N> dto)
    {
        this.original = original;
        this.dto = dto;
    }

    public ObjectUtils(Class<T> original)
    {
        this.original = original;
    }


    public T mergeFields (T originalObject, N objectDTO)
    {


        for (Field field : dto.getDeclaredFields())
        {

            try
            {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(objectDTO);

                if (value != null)
                {
                    Field f = original.getField(name);
                    f.setAccessible(true);
                    f.set(originalObject, value);
                }
            }
            catch (IllegalAccessException e)
            {
                return null;
            }
            catch (NoSuchFieldException e)
            {
                return null;
            }

        }


        return originalObject;
    }


}
