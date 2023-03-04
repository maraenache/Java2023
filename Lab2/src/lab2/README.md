# AdvancedProgramming2023
## Compulsory

------


- [x] Create an object-oriented model of the problem. You should have (at least) the following classes: Location, Road.
  The location and road types will be implemented as enums.
- [x] Each class should have appropriate constructors, getters and setters.
  Use the IDE features for code generation, such as generating getters and setters.
- [x] The toString method form the Object class must be properly overridden for all the classes.
  Use the IDE features for code generation, for example (in NetBeans) press Alt+Ins or invoke the context menu, select "Insert Code" and then "toString()" (or simply start typing "toString" and then press Ctrl+Space).
- [x] Create and print on the screen various objects of the two classes.



## Homework

------  
- [ ] Create a class that describes an instance of the problem.
- [ ] Override the Object.equals method for the Location and Road classes. The problem should not allow adding the same location or road twice.
- [ ] Instead of using an enum, create dedicated classes either for locations: cities, air ports, gas stations etc. or roads: highway, express, country, etc. Each concrete location class may have additional specific propertes (population, number of terminals, gas price, etc.).
- [ ] Implement a method that determines if a problem's instance is valid.
- [ ] Implement an algorithm for determining if it is possible to go from one location to another using the given roads.
- [ ] Write doc comments in your source code and generate the class documentation using javadoc.

## Bonus

------  
- [ ] Create a class to describe the solution.
- [ ] Implement an algorithm to find the best route from a location to another, either as the shortest route, or the fastest route.
- [ ] Generate large random instances of the problem and analyze the performance of your algorithm (running times, memory consumption).