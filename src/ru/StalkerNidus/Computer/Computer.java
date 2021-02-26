package ru.StalkerNidus.Computer;

import java.util.Arrays;

public class Computer {
    private CPU cpu;
    private GPU gpu;
    private Memory[] memoriesBlocks;

    public Computer(CPU cpu, GPU gpu, Memory[] memoriesBlocks) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.memoriesBlocks = memoriesBlocks;
    }

    public float getRating(){
        return cpu.getMaxFrequency() * 0.95f * cpu.getCore() + gpu.getMemory() * 0.2f + gpu.getRtx();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu +
                ", gpu=" + gpu +
                ", memoriesBlocks=" + Arrays.toString(memoriesBlocks) +
                '}';
    }

    public Computer copy(){
        Computer newPC = new Computer(cpu.copy(), gpu.copy(), new Memory[memoriesBlocks.length]);
        for(int i=0; i< memoriesBlocks.length; i++){
            newPC.memoriesBlocks[i]=memoriesBlocks[i].copy();
        }
        return newPC;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public Memory[] getMemoriesBlocks() {
        return memoriesBlocks;
    }

    public void setMemoriesBlocks(Memory[] memoriesBlocks) {
        this.memoriesBlocks = memoriesBlocks;
    }
}
