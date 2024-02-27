package hk.ust.cse.comp3021.lab2;

/**
 * {@link Bus} class represents a bus that can be added to the instance of {@link BusCompany} via {@link BusCompany#createAndAddBus(int, String)}.
 */

public class Bus {
    private int busId;
    private String modelName;

    /**
     * Initialize a new BusCompany instance.
     *
     * @param name the name of the bus company.
     */
    public Bus(int id, String modelName) {
        this.busId = id;
        this.modelName = modelName;
    }

    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
