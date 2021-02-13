ALTER TABLE test.avion ADD COLUMN (revisionjson JSON);
ALTER TABLE test.vuelo ADD COLUMN (tripulantesjson JSON);
update test.avion a set a.revisionjson = (SELECT JSON_ARRAYAGG(json_object('id', r.id,
                                                                         'descripcion_trabajo', r.descripcion_trabajo,
                                                                         'fecha_inicio',r.fecha_inicio,
                                                                         'fecha_fin',r.fecha_fin,
                                                                         'num_horas_empleadas',r.num_horas_empleadas,
                                                                         'tipo_revision',r.tipo_revision,
                                                                         'aeropuerto_id', r.aeropuerto_id,
                                                                         'avion_id', r.avion_id,
                                                                         'mecanico_id', r.mecanico_id) )
                                        FROM revision r
                                        where a.id = r.avion_id);

update test.vuelo v set v.tripulantesjson = (SELECT JSON_ARRAYAGG(id) AS tripulantes
                                         from tripulante t, vuelo_tripulante vt
                                         where v.id = vt.vue_id and vt.tri_id = t.id
                                         group by vt.vue_id
);