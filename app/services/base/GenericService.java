package services.base;

import org.springframework.transaction.annotation.Transactional;
import services.exceptions.NotFoundException;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eduardo on 5/04/15.
 */
public interface GenericService<T,I extends Serializable>
{
    /**
     * Creates a new set of elements.
     *
     * @param entity The information of the created element.
     *
     * @return The created element.
     */

    @Transactional

    public Iterable< T > save( Iterable< T > entity );


    /**
     * Creates a new element.
     *
     * @param entity The information of the created element.
     *
     * @return The created element.
     */

    @Transactional

    public T save( T entity );

    /**
     * Updates the information of a element.
     *
     * @param updated The information of the updated element.
     *
     * @return The updated element.
     *
     * @throws services.exceptions.NotFoundException if no element is found with given id.
     */
    @Transactional( rollbackFor = NotFoundException.class )
    public T update( I id, Object updated ) throws NotFoundException;


    /**
     * Deletes a person.
     *
     * @param id The id of the deleted person.
     *
     * @return The deleted person.
     *
     * @throws NotFoundException if no person is found with the given id.
     */
    @Transactional( rollbackFor = NotFoundException.class )
    public boolean delete( I id ) throws NotFoundException;


    /**
     * Finds all persons.
     *
     * @return A list of persons.
     */
    @Transactional(readOnly = true)
    public List< T > findAll();


    /**
     * Finds person by id.
     *
     * @param id The id of the wanted person.
     *
     * @return The found person. If no person is found, this method returns null.
     */
    @Transactional(readOnly = true)
    public T findById( I id );

    void copyProperties (Object src, Object target);

    public String[] getNullPropertyNames (Object source);
}
