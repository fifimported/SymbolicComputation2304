used_pairs = []

EDGES_PER_CITY = 4
for city1 in cities:
    edge_num = 1
    for city2 in cities:
        city1_name = city1[0]
        city2_name = city2[0]
        if city1_name == city2_name:
            continue
        mis = min(city1_name, city2_name)
        mas = max(city1_name, city2_name)
        key = mis + mas
        if key in used_pairs:
            continue
        if edge_num >= EDGES_PER_CITY:
            break
        edge_num = edge_num + 1
        used_pairs.append(key)
        price = random.randint(2, 5) * 100
        id1 = city1[1]
        id2 = city2[1]
        edges.append([city1_name, city2_name, price, id1, id2])
