/*package org.example.bonus;
import org.graph4j.*;
import org.graph4j.alg.coloring.GreedyColoring;
import org.graph4j.alg.coloring.VertexColoring;

public class MyGreedyColoring<V, E> extends GreedyColoring<V, E> implements VertexColoring<V> {

    public MyGreedyColoring(Graph<V, E> graph) {
        super(graph);
    }

    @Override
    protected Iterable<V> getVertexOrdering() {
        // You can customize the vertex ordering used by the algorithm
        return super.getVertexOrdering(); // Just use the default ordering for now
    }

    @Override
    public Coloring<V> getColoring() {
        int maxColor = -1;
        Map<V, Integer> colors = new HashMap<>();
        Set<Integer> used = new HashSet<>();

        for (V v : getVertexOrdering()) {
            // find used colors
            for (E e : graph.edgesOf(v)) {
                V u = Graphs.getOppositeVertex(graph, e, v);
                if (v.equals(u)) {
                    throw new IllegalArgumentException(SELF_LOOPS_NOT_ALLOWED);
                }
                if (colors.containsKey(u)) {
                    used.add(colors.get(u));
                }
            }

            // find first free
            int candidate = 0;
            while (used.contains(candidate)) {
                candidate++;
            }
            used.clear();

            // set color
            colors.put(v, candidate);
            maxColor = Math.max(maxColor, candidate);
        }

        return new ColoringImpl<>(colors, maxColor + 1);
    }
}
*/