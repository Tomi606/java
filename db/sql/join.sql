select board.*, co_name as bo_co_name, 
		sum(case when re_state = 1 then 1 else 0 end) as bo_up,
		sum(case when re_state = -1 then 1 else 0 end) as bo_down
		from board file
		join community on co_num = bo_co_num
		left join recommend on re_bo_num = bo_num
		group by bo_num
		order by bo_num desc
		limit 0, 5