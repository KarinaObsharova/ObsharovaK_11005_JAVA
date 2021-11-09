create table graph(
                      id serial primary key,
                      from_node varchar(10),
                      to_node varchar(10),
                      weight int
);

insert into graph(from_node, to_node, weight) VALUES ('S', 'U', 3);
insert into graph(from_node, to_node, weight) VALUES ('S', 'X', 5);
insert into graph(from_node, to_node, weight) VALUES ('U', 'V', 6);
insert into graph(from_node, to_node, weight) VALUES ('U', 'X', 2);
insert into graph(from_node, to_node, weight) VALUES ('X', 'U', 1);
insert into graph(from_node, to_node, weight) VALUES ('X', 'Y', 6);
insert into graph(from_node, to_node, weight) VALUES ('X', 'V', 4);
insert into graph(from_node, to_node, weight) VALUES ('V', 'Y', 2);
insert into graph(from_node, to_node, weight) VALUES ('Y', 'V', 7);
insert into graph(from_node, to_node, weight) VALUES ('Y', 'S', 3);


WITH recursive
    way_from_s_to_y(to_node2, steps, DISTANCE, way)
        AS
        (SELECT DISTINCT from_node, 0, 0, 'S'
         FROM graph
         WHERE from_node = 'S'
         UNION ALL
         SELECT to_node,
                wfsty.steps + 1,
                wfsty.DISTANCE + graph.weight,
                wfsty.way || ', ' || graph.to_node
         from graph
                  INNER JOIN way_from_s_to_y AS wfsty
                             ON wfsty.to_node2 = graph.from_node),

    short(DISTANCE)
        AS (SELECT MIN(DISTINCT)
            FROM way_from_s_to_y
            WHERE to_node2 = 'Y')


SELECT *
FROM way_from_s_to_y way
         INNER JOIN short s ON s.DISTANCE = way.DISTANCE;
