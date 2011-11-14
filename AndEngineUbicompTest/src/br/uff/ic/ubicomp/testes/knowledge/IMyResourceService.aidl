package br.uff.ic.ubicomp.testes.knowledge;

interface IMyResourceService {
		
		void createResource(String name, String id, int onOff, int x, int y);
		String getResource();
}
