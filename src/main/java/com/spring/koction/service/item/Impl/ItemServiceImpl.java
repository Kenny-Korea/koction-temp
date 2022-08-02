package com.spring.koction.service.item.Impl;


import com.spring.koction.entity.ItemFile;
import com.spring.koction.repository.ItemRepository;
import com.spring.koction.repository.ItemqRepository;
=======
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.koction.entity.Item;
import com.spring.koction.entity.ItemFile;
import com.spring.koction.mapper.ItemMapper;
import com.spring.koction.repository.ItemFileRepository;
import com.spring.koction.repository.ItemRepository;
import com.spring.koction.service.item.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{
  @Autowired
	ItemRepository itemRepository;
	@Autowired
	ItemqRepository itemqRepository;

	@Autowired
	ItemMapper itemMapper;
	
	@Autowired
	ItemFileRepository itemFileRepository;


	@Override
	public Page<Item> getItemList(Item item, Pageable pageable) {
		return null;
	}

	@Override


	@Override
	public Item getMyItem(int itemNo) {
		return itemRepository.findById(itemNo).get();
	}

	@Override
	public void updateItem(Item item) {
		itemRepository.save(item);
	}

	@Override
	public List<ItemFile> getItemFileList(int itemNo) {
		return null;

	public int regitserItem(Item item) {
		int itemNo = itemMapper.getNextItemNo();
		item.setItemNo(itemNo);
		itemRepository.save(item);
		itemRepository.flush();
		return itemNo;
	}

	@Override
	public void registerItemFile(List<ItemFile> fileList) {
		for(ItemFile itemFile : fileList) {
			itemFile.setItemfileNo(itemFileRepository.selectNextItemNoByItemItemNo(itemFile.getItem().getItemNo()));
			itemFileRepository.save(itemFile);
		}
		

	}

}
