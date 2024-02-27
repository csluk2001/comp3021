package hk.ust.cse.comp3021.lab2;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * {@link BusCompany} represents a bus company class, whose instance contains a list of {@link Bus} instances.
 * {@link BusCompany} should also keep tracking the total number of {@link BusCompany} instances that has been created
 * (those that are garbage-collected should also be counted).
 */
public class BusCompany {
    private final String busCompanyName;
    private int numOfBus;
    List<Bus> listOfBus;
    static int totalNumberOfBusCompany;

    /**
     * Initialize a new BusCompany instance.
     *
     * @param name the name of the bus company.
     */
    public BusCompany(@NotNull String name) {
        this.busCompanyName = name;
        this.numOfBus = 0;
        listOfBus = new ArrayList<>();
        BusCompany.totalNumberOfBusCompany++;
    }

    /**
     * @return the name of the bus company.
     */
    @NotNull
    public String getName() {
        return this.busCompanyName;
    }

    /**
     * @return the number of {@link Bus} instances that current bus company has.
     */
    public int getNumBuses() {
        return this.numOfBus;
    }

    /**
     * @param id the id of the bus instance in current bus company.
     * @return the {@link Bus} instance with the {@code id} in the current bus company. Return null if not exist.
     */
    @Nullable
    public Bus getBusByID(int id) {
        for (Bus bus : this.listOfBus) {
            if (bus.getBusId() == id) {
                return bus;
            }
        }
        return null;
    }

    /**
     * @return an array of unique models used in current bus company. There should not be two equivalent models in the returned array.
     * If there are no {@link Bus} instances in the current bus company, return an empty array with length 0.
     */
    @NotNull
    public String[] getModels() {
        if (this.numOfBus == 0) {
            return new String[]{};
        }
        Set<String> modelsName = new HashSet<>();
        for (Bus bus : this.listOfBus) {
            modelsName.add(bus.getModelName());
        }
        return modelsName.toArray(new String[0]);
    }

    /**
     * Create a new {@link Bus} instance and add to the current bus company.
     * Each {@link Bus} instance added to the {@link BusCompany} instance should have unique {@link Bus} id.
     * If the given id already exists in the current {@link BusCompany} instance, do not add any {@link Bus} instance and just return false.
     * Otherwise, if a new {@link Bus} instance is successfully added, return true.
     *
     * @param id    the id of the bus to be created.
     * @param model the model of the bus to be created.
     * @return whether a new bus instance is added to the bus company.
     */
    public boolean createAndAddBus(int id, String model) {
        if (this.getBusByID(id) != null) {
            return false;
        }
        Bus newBus = new Bus(id, model);
        this.numOfBus++;
        this.listOfBus.add(newBus);
        return true;
    }

    /**
     * Remove all {@link Bus} instances that have been added to the current bus company via {@link BusCompany#createAndAddBus(int, String)}.
     */
    public void removeAllBuses() {
        this.numOfBus = 0;
        this.listOfBus = null;
    }

    /**
     * @return the total number of {@link BusCompany} instances that have been created.
     */
    public static int getNumCompanies() {
        return BusCompany.totalNumberOfBusCompany;
    }

}

