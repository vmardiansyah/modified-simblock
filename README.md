## This is a Modified SimBlock Simulator
This program is a modification of the SimBlock simulator, intended to show the mining process that occurs using the Proof-of-Work concept. The Block creation in modified SimBlock is using a difficulty factor based on the number of leading-zero as the target hash.

For example:

Difficulty = 1, meaning to find one leading-zero as the target hash.

Difficulty = 2, meaning to find two leading-zero as the target hash, etc.

You can change this Difficulty setting at SimulationConfiguration.java file on the setting folder.

You can see the different JSON output when finish re-compile this simulator.

Note to remember, the higher the Difficulty will need more time to re-compile the simulator.

Here are the difference output that we made.

###Original SimBlock [output.json]
![image](https://user-images.githubusercontent.com/54434087/198306499-83473e4b-9fed-4305-8749-914cb42fdf75.png)

###Modified SimBlock [output.json].
![image](https://user-images.githubusercontent.com/54434087/198304847-c1682621-728c-41ef-92dd-5d30f8f93391.png)


## What is SimBlock?

SimBlock is an open source blockchain network simulator, developed by Distributed Systems Group, Tokyo Institute of Technology.

Original source code is available:
https://dsg-titech.github.io/simblock/

- [User Guide (English)](https://github.com/dsg-titech/simblock/blob/master/docs/en/usage.md)
- [User Guide (Japanese)](https://github.com/dsg-titech/simblock/blob/master/docs/jp/usage.md)

SimBlock has a visualization tool, by which you can see the transition of block propagation.

- [SimBlock Visualizer](https://github.com/dsg-titech/simblock-visualizer)

## License

SimBlock is licensed under the Apache License, Version2.0.

## Contact

E-mail: dsg-titech at googlegroups.com
